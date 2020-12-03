package com.kodilla.good.patterns.challenges;

public class Runner {

    public static void main(String[] args) {

        //13.1----------------------------------------------------

        MovieStore movieStore = new MovieStore();
        System.out.println(movieStore.getAllTitles(movieStore.getMovies()));

        //13.2-----------------------------------------------------

        InformationService informationService = new InformationService() {
            @Override
            public void inform(TradeRequest tradeRequest) {
                System.out.println("Mail sent to: " + tradeRequest.getBuyer());
                System.out.println("Mail sent to: " + tradeRequest.getSeller());
            }
        };

        TradingRepository tradingRepository = new TradingRepository() {
            @Override
            public boolean createTrade(TradeRequest tradeRequest) {
                System.out.println(tradeRequest + " was created.");
                return true;
            }
        };

        TradingService tradingService = new TradingService() {
            @Override
            public boolean trade(TradeRequest tradeRequest) {
                System.out.println(tradeRequest + " was made.");
                return true;
            }
        };

        ProductOrderService productOrderService = new ProductOrderService(informationService,tradingService,tradingRepository);
        TradeRequest tradeRequest = new TradeRequest(new User("Mariusz","Kuryła"),new User("Will","Smith"),new Item("Umbrella"));
        productOrderService.process(tradeRequest);

        //13.4------------------------------------------------

        Producer extraFoodShop = new Producer() {

            private Food2DoorInformationService food2DoorInformationService = new Food2DoorInformationService() {
                @Override
                public void inform(OrderDto orderDto) {
                    System.out.println("Information sent.");
                }
            };
            private OrderRepository orderRepository = new OrderRepository() {
                @Override
                public void sendToRepository(OrderDto orderDto) {
                    System.out.println("Order was made.");
                }
            };

            @Override
            public void differenceInProcess(OrderDto orderDto) {
                orderDto.getOrder().getSupplier().setSupplierID(orderDto.getOrder().getSupplier().getSupplierID()+10000000);
                orderRepository.sendToRepository(orderDto);
                food2DoorInformationService.inform(orderDto);
                System.out.println(orderDto.getOrder());
            }

            @Override
            public void process(Order order) { differenceInProcess(Producer.commonProcess(order)); }
        };

        Producer healthyShop = new Producer() {

            private Food2DoorInformationService food2DoorInformationService = new Food2DoorInformationService() {
                @Override
                public void inform(OrderDto orderDto) {
                    System.out.println("Information sent.");
                }
            };
            private OrderRepository orderRepository = new OrderRepository() {
                @Override
                public void sendToRepository(OrderDto orderDto) {
                    System.out.println("Order was made.");
                }
            };

            @Override
            public void differenceInProcess(OrderDto orderDto) {
                orderRepository.sendToRepository(orderDto);
                food2DoorInformationService.inform(orderDto);
            }

            @Override
            public void process(Order order) { differenceInProcess(Producer.commonProcess(order)); }
        };

        Producer glutenFreeShop = new Producer() {

            private Food2DoorInformationService food2DoorInformationService = new Food2DoorInformationService() {
                @Override
                public void inform(OrderDto orderDto) {
                    System.out.println("Information sent.");
                }
            };
            private OrderRepository orderRepository = new OrderRepository() {
                @Override
                public void sendToRepository(OrderDto orderDto) {
                    System.out.println("Order was made.");
                }
            };

            private Food2DoorInformationService sponsorInformationService = new Food2DoorInformationService() {
                @Override
                public void inform(OrderDto orderDto) {
                    System.out.println("Information sent to sponsor.");
                }
            };
            private OrderRepository sponsorRepository = new OrderRepository() {
                @Override
                public void sendToRepository(OrderDto orderDto) {
                    System.out.println("Order is saved in sponsor repository.");
                }
            };

            @Override
            public void differenceInProcess(OrderDto orderDto) {
                sponsorRepository.sendToRepository(orderDto);
                sponsorInformationService.inform(orderDto);
                orderRepository.sendToRepository(orderDto);
                food2DoorInformationService.inform(orderDto);
            }

            @Override
            public void process(Order order) { differenceInProcess(Producer.commonProcess(order));}
        };

        Order order = new Order(new Supplier("Mariusz","Kuryła",1110111),999.9,"flour (kg)");
        extraFoodShop.process(order);
        healthyShop.process(order);
        glutenFreeShop.process(order);

        //13.5----------------------------------------------------------

        FlightMap flightMap = new FlightMap();
        Airport barcelona = new Airport("Barcelona","BAR");
        Airport warsaw = new Airport("Warsaw", "WAR");
        Airport paris = new Airport("Paris","PAR");
        flightMap.findFrom(barcelona);
        flightMap.findTo(warsaw);
        flightMap.findThrough(barcelona,paris,warsaw);

    }
}
