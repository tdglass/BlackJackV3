package sample;

import javafx.scene.image.Image;
import java.util.Random;

public class Card {
    private int counter = 0;

    public Card[] deck = new Card[52];
    private int cardValue;
    private Image imageOfCard;
    private boolean usedCard;
    private int handValue;
    private int bettingValue;
    private int totalCash;
    private float winPercentage;
    private float totalHands;
    private float totalWins;

    public void createDeck() {
        for (int i = 0; i < 52 ; i++) { //Initialize every object in the array as a Card().
            deck[i] = new Card();
        }
        deck[0].cardValue = 2; deck[0].imageOfCard = new Image("sample/images/2C.jpg"); deck[0].usedCard = false;
        deck[1].cardValue = 3; deck[1].imageOfCard = new Image("sample/images/3C.jpg"); deck[1].usedCard = false;
        deck[2].cardValue = 4; deck[2].imageOfCard = new Image("sample/images/4C.jpg"); deck[2].usedCard = false;
        deck[3].cardValue = 5; deck[3].imageOfCard = new Image("sample/images/5C.jpg"); deck[3].usedCard = false;
        deck[4].cardValue = 6; deck[4].imageOfCard = new Image("sample/images/6C.jpg"); deck[4].usedCard = false;
        deck[5].cardValue = 7; deck[5].imageOfCard = new Image("sample/images/7C.jpg"); deck[5].usedCard = false;
        deck[6].cardValue = 8; deck[6].imageOfCard = new Image("sample/images/8C.jpg"); deck[6].usedCard = false;
        deck[7].cardValue = 9; deck[7].imageOfCard = new Image("sample/images/9C.jpg"); deck[7].usedCard = false;
        deck[8].cardValue = 10; deck[8].imageOfCard = new Image("sample/images/10C.jpg"); deck[8].usedCard = false;
        deck[9].cardValue = 10; deck[9].imageOfCard = new Image("sample/images/JC.jpg"); deck[9].usedCard = false;
        deck[10].cardValue = 10; deck[10].imageOfCard = new Image("sample/images/QC.jpg"); deck[10].usedCard = false;
        deck[11].cardValue = 10; deck[11].imageOfCard = new Image("sample/images/KC.jpg"); deck[11].usedCard = false;
        deck[12].cardValue = 11; deck[12].imageOfCard = new Image("sample/images/AC.jpg"); deck[12].usedCard = false;
        deck[13].cardValue = 2; deck[13].imageOfCard = new Image("sample/images/2S.jpg"); deck[13].usedCard = false;
        deck[14].cardValue = 3; deck[14].imageOfCard = new Image("sample/images/3S.jpg"); deck[14].usedCard = false;
        deck[15].cardValue = 4; deck[15].imageOfCard = new Image("sample/images/4S.jpg"); deck[15].usedCard = false;
        deck[16].cardValue = 5; deck[16].imageOfCard = new Image("sample/images/5S.jpg"); deck[16].usedCard = false;
        deck[17].cardValue = 6; deck[17].imageOfCard = new Image("sample/images/6S.jpg"); deck[17].usedCard = false;
        deck[18].cardValue = 7; deck[18].imageOfCard = new Image("sample/images/7S.jpg"); deck[18].usedCard = false;
        deck[19].cardValue = 8; deck[19].imageOfCard = new Image("sample/images/8S.jpg"); deck[19].usedCard = false;
        deck[20].cardValue = 9; deck[20].imageOfCard = new Image("sample/images/9S.jpg"); deck[20].usedCard = false;
        deck[21].cardValue = 10; deck[21].imageOfCard = new Image("sample/images/10S.jpg"); deck[21].usedCard = false;
        deck[22].cardValue = 10; deck[22].imageOfCard = new Image("sample/images/JS.jpg"); deck[22].usedCard = false;
        deck[23].cardValue = 10; deck[23].imageOfCard = new Image("sample/images/QS.jpg"); deck[23].usedCard = false;
        deck[24].cardValue = 10; deck[24].imageOfCard = new Image("sample/images/KS.jpg"); deck[24].usedCard = false;
        deck[25].cardValue = 11; deck[25].imageOfCard = new Image("sample/images/AS.jpg"); deck[25].usedCard = false;
        deck[26].cardValue = 2; deck[26].imageOfCard = new Image("sample/images/2S.jpg"); deck[26].usedCard = false;
        deck[27].cardValue = 3; deck[27].imageOfCard = new Image("sample/images/3D.jpg"); deck[27].usedCard = false;
        deck[28].cardValue = 4; deck[28].imageOfCard = new Image("sample/images/4D.jpg"); deck[28].usedCard = false;
        deck[29].cardValue = 5; deck[29].imageOfCard = new Image("sample/images/5D.jpg"); deck[29].usedCard = false;
        deck[30].cardValue = 6; deck[30].imageOfCard = new Image("sample/images/6D.jpg"); deck[30].usedCard = false;
        deck[31].cardValue = 7; deck[31].imageOfCard = new Image("sample/images/7D.jpg"); deck[31].usedCard = false;
        deck[32].cardValue = 8; deck[32].imageOfCard = new Image("sample/images/8D.jpg"); deck[32].usedCard = false;
        deck[33].cardValue = 9; deck[33].imageOfCard = new Image("sample/images/9D.jpg"); deck[33].usedCard = false;
        deck[34].cardValue = 10; deck[34].imageOfCard = new Image("sample/images/10D.jpg"); deck[34].usedCard = false;
        deck[35].cardValue = 10; deck[35].imageOfCard = new Image("sample/images/JD.jpg"); deck[35].usedCard = false;
        deck[36].cardValue = 10; deck[36].imageOfCard = new Image("sample/images/QD.jpg"); deck[36].usedCard = false;
        deck[37].cardValue = 10; deck[37].imageOfCard = new Image("sample/images/KD.jpg"); deck[37].usedCard = false;
        deck[38].cardValue = 11; deck[38].imageOfCard = new Image("sample/images/AD.jpg"); deck[38].usedCard = false;
        deck[39].cardValue = 2; deck[39].imageOfCard = new Image("sample/images/2D.jpg"); deck[39].usedCard = false;
        deck[40].cardValue = 3; deck[40].imageOfCard = new Image("sample/images/3H.jpg"); deck[40].usedCard = false;
        deck[41].cardValue = 4; deck[41].imageOfCard = new Image("sample/images/4H.jpg"); deck[41].usedCard = false;
        deck[42].cardValue = 5; deck[42].imageOfCard = new Image("sample/images/5H.jpg"); deck[42].usedCard = false;
        deck[43].cardValue = 6; deck[43].imageOfCard = new Image("sample/images/6H.jpg"); deck[43].usedCard = false;
        deck[44].cardValue = 7; deck[44].imageOfCard = new Image("sample/images/7H.jpg"); deck[44].usedCard = false;
        deck[45].cardValue = 8; deck[45].imageOfCard = new Image("sample/images/8H.jpg"); deck[45].usedCard = false;
        deck[46].cardValue = 9; deck[46].imageOfCard = new Image("sample/images/9H.jpg"); deck[46].usedCard = false;
        deck[47].cardValue = 10; deck[47].imageOfCard = new Image("sample/images/10H.jpg"); deck[47].usedCard = false;
        deck[48].cardValue = 10; deck[48].imageOfCard = new Image("sample/images/JH.jpg"); deck[48].usedCard = false;
        deck[49].cardValue = 10; deck[49].imageOfCard = new Image("sample/images/QH.jpg"); deck[49].usedCard = false;
        deck[50].cardValue = 10; deck[50].imageOfCard = new Image("sample/images/KH.jpg"); deck[50].usedCard = false;
        deck[51].cardValue = 11; deck[51].imageOfCard = new Image("sample/images/AH.jpg"); deck[51].usedCard = false;
    } //Storing value, image and whether the card has been used in an object array.

    /*
    The randomCard method gets an unused card from the deck array, passes the value
    of the random card to the setHandValue method, sets that card as "used" and then
    returns the image of that card to be displayed.
     */
    public Image randomCard(){
        int storedRandomNumber;
        Random randomNum = new Random();
        setCounter(getCounter()+1);
                      //Counter to keep track of how many cards have been used.

        if (getCounter() == 52) {    //If all cards have been used, "shuffle" the deck.
            createDeck();
            setCounter(0);
        }

        do{
            storedRandomNumber = randomNum.nextInt(52); //
        }while (deck[storedRandomNumber].usedCard); //Keep finding a random number until we find a card that hasn't been used.

        deck[storedRandomNumber].usedCard = true;   //Card is now used.

        setHandValue(deck[storedRandomNumber].cardValue); //Pass card value to setHandValue.

        return deck[storedRandomNumber].imageOfCard; //Return the image of the card
    }


    public int getHandValue() {
        return handValue;
    }

    public void setHandValue(int handValue) {
        if (handValue == 0 ){  //Reset hand total if passed a value of 0.
            this.handValue = 0;
        } else {this.handValue += handValue;} //Running total for computer or player1 hand value.
    }

    public int getBettingValue() {
        return bettingValue;
    }

    public void setBettingValue(int bettingValue) {
        if (bettingValue == 0){
            this.bettingValue = 0;
        } else {
            this.bettingValue += bettingValue;
        }
    }

    public int getTotalCash() {
        return totalCash;
    }

    public void setTotalCash(int totalCash) {
        this.totalCash = totalCash;
    }

    public float getWinPercentage() {
        return Math.round(winPercentage);
    }

    public void setWinPercentage(float handsPlayed, float handsWon) {
        this.winPercentage = handsWon/handsPlayed * 100;
    }

    public float getTotalHands() {
        return totalHands;
    }

    public void setTotalHands(float totalHands) {
        this.totalHands += totalHands;
    }

    public float getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(float totalWins) {
        this.totalWins += totalWins;
    }

    private int getCounter() {
        return counter;
    }

    private void setCounter(int counter) {
        this.counter = counter;
    }
}
