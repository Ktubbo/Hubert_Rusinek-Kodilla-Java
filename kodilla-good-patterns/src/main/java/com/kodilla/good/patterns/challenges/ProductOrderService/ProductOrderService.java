package main.java.com.kodilla.good.patterns.challenges.ProductOrderService;

public class ProductOrderService {

    private InformationService informationService;
    private TradingService tradingService;
    private TradingRepository tradingRepository;

    public ProductOrderService(final InformationService informationService,
                           final TradingService tradingService,
                           final TradingRepository tradingRepository) {
        this.informationService = informationService;
        this.tradingService = tradingService;
        this.tradingRepository = tradingRepository;
    }

    public TradeDto process(final TradeRequest tradeRequest) {
        boolean isTraded = tradingService.trade(tradeRequest.getSeller(), tradeRequest.getBuyer(),
                tradeRequest.getItem());

        if (isTraded) {
            informationService.inform(tradeRequest.getSeller(), tradeRequest.getBuyer());
            tradingRepository.createTrade(tradeRequest.getSeller(), tradeRequest.getBuyer(), tradeRequest.getItem());
            return new TradeDto(tradeRequest.getItem(), true);
        } else {
            return new TradeDto(tradeRequest.getItem(), false);
        }
    }
}


