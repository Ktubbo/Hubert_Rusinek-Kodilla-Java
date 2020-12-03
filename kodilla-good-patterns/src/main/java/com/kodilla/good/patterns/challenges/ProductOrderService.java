package com.kodilla.good.patterns.challenges;

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
        boolean isTraded = tradingService.trade(tradeRequest);

        if (isTraded) {
            informationService.inform(tradeRequest);
            tradingRepository.createTrade(tradeRequest);
            return new TradeDto(tradeRequest.getItem(), true);
        } else {
            return new TradeDto(tradeRequest.getItem(), false);
        }
    }
}


