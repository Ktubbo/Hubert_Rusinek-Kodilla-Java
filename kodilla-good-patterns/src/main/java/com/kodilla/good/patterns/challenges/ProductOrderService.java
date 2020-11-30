package main.java.com.kodilla.good.patterns.challenges;


interface InformationService {
    void inform(User buyer, User seller);
}

interface TradingService {
    boolean trade(User buyer, User seller, Item item);
}

interface TradingRepository {
    boolean createTrade(User buyer, User seller, Item item);
}

interface Item {

}

class User {

    String name;
    String surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}

class TradeDto {

    public Item item;
    public boolean isTraded;

    public TradeDto(final Item item, final boolean isTraded) {
        this.item = item;
        this.isTraded = isTraded;
    }

    public Item getItem() {
        return item;
    }

    public boolean isTraded() {
        return isTraded;
    }
}

class TradeRequest {

    private User seller;
    private User buyer;
    private Item item;

    public TradeRequest(final User seller, final User buyer, final Item item) {
        this.seller = seller;
        this.buyer = buyer;
        this.item = item;
    }

    public User getSeller() {
        return seller;
    }

    public User getBuyer() {
        return buyer;
    }

    public Item getItem() {
        return item;
    }
}

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


