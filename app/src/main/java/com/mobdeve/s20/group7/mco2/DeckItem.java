package com.mobdeve.s20.group7.mco2;

import java.util.ArrayList;
import java.util.List;

public class DeckItem {

    // Attributes for Deck Image, Title, and List of CardItems
    private String deckImage; // URL or file path to the deck image
    private String deckTitle;
    private List<CardItem> cardItems;

    // Constructor
    public DeckItem(String deckImage, String deckTitle) {
        this.deckImage = deckImage;
        this.deckTitle = deckTitle;
        this.cardItems = new ArrayList<>();
    }

    // Add a CardItem to the deck
    public void addCardItem(CardItem cardItem) {
        cardItems.add(cardItem);
    }

    // Getters
    public String getDeckImage() {
        return deckImage;
    }

    public String getDeckTitle() {
        return deckTitle;
    }

    public List<CardItem> getCardItems() {
        return cardItems;
    }

    // Get a CardItem by index
    public CardItem getCardItem(int index) {
        if (index >= 0 && index < cardItems.size()) {
            return cardItems.get(index);
        }
        return null; // Handle out-of-bounds access
    }
}
