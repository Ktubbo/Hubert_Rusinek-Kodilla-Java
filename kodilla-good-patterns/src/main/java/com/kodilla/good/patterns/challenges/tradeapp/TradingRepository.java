package com.kodilla.good.patterns.challenges.tradeapp;

interface TradingRepository {
    boolean createTrade(TradeRequest tradeRequest);
}
