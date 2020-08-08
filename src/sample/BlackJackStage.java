package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class BlackJackStage {
    @FXML private ImageView cardOnePlayerImage;
    @FXML private ImageView cardTwoPlayerImage;
    @FXML private ImageView cardThreePlayerImage;
    @FXML private ImageView cardFourPlayerImage;
    @FXML private ImageView cardFivePlayerImage;
    @FXML private ImageView cardSixPlayerImage;
    @FXML private ImageView cardOneComputerImage;
    @FXML private ImageView cardTwoComputerImage;
    @FXML private ImageView cardThreeComputerImage;
    @FXML private ImageView cardFourComputerImage;
    @FXML private ImageView cardFiveComputerImage;
    @FXML private ImageView cardSixComputerImage;
    @FXML private Button hitMeButton;
    @FXML private Button stayButton;
    @FXML private Label information;
    @FXML private Button dealButton;
    @FXML private Button bet5;
    @FXML private Button bet25;
    @FXML private Button bet100;
    @FXML private Label totalBetBox;
    @FXML private Label cashCountBox;
    @FXML private Button nextHandButton;
    @FXML private Label winPercentBox;

    int imageViewCounter = 0;
    Card player1Hand = new Card();
    Card computerHand = new Card();


    public void dealButton () {       //Get first two cards
        bet5.setVisible(false);
        bet25.setVisible(false);
        bet100.setVisible(false);
        player1Hand.createDeck();
        computerHand.createDeck();
        cardOnePlayerImage.setImage(player1Hand.randomCard()); setImageViewCounter(getImageViewCounter()+1);
        cardTwoPlayerImage.setImage(player1Hand.randomCard()); setImageViewCounter(getImageViewCounter()+1);
        hitMeButton.setVisible(true);
        stayButton.setVisible(true);
        dealButton.setVisible(false);
        information.setText(Integer.toString(player1Hand.getHandValue()));
    }

    public void hitMeButton () {
        setImageViewCounter(getImageViewCounter()+1); //Counter used for matching the image into which image viewer box.

        switch (getImageViewCounter()) {
            case 3 -> cardThreePlayerImage.setImage(player1Hand.randomCard());
            case 4 -> cardFourPlayerImage.setImage(player1Hand.randomCard());
            case 5 -> cardFivePlayerImage.setImage(player1Hand.randomCard());
            case 6 -> cardSixPlayerImage.setImage(player1Hand.randomCard());
        }
        information.setText(Integer.toString(player1Hand.getHandValue())); //Display total hand count into info label.
        if (player1Hand.getHandValue()>21){         //If player1 busts.
            player1Lose();
            setWinPercentageBox();
            information.setText("BUST you lose.");
            hitMeButton.setVisible(false);
            stayButton.setVisible(false);
            nextHandButton.setVisible(true);
        }
    }

    public void stayButton () { //On player 1 stay, get computer cards/total until computer total is <= 17.
        setImageViewCounter(0);   //Reused counter from player 1, reset to 0.
        hitMeButton.setVisible(false);
        stayButton.setVisible(false);
        do {
            setImageViewCounter(getImageViewCounter()+1);
            switch (getImageViewCounter()){
                case 1 -> cardOneComputerImage.setImage(computerHand.randomCard());
                case 2 -> cardTwoComputerImage.setImage(computerHand.randomCard());
                case 3 -> cardThreeComputerImage.setImage(computerHand.randomCard());
                case 4 -> cardFourComputerImage.setImage(computerHand.randomCard());
                case 5 -> cardFiveComputerImage.setImage(computerHand.randomCard());
                case 6 -> cardSixComputerImage.setImage(computerHand.randomCard());
            }

        } while (computerHand.getHandValue()<=17);

        if (computerHand.getHandValue()>21){ //After getting computer total, see who wins.
            information.setText("Computer bust, you win.");
            player1Win();
            setWinPercentageBox();
        } else if(player1Hand.getHandValue()>computerHand.getHandValue()){
            information.setText("You win the hand.");
            player1Win();
            setWinPercentageBox();
        } else if (player1Hand.getHandValue()<computerHand.getHandValue()){
            player1Lose();
            setWinPercentageBox();
            information.setText("You lose the hand");
        } else {
            information.setText("PUSH");
            player1Hand.setTotalHands(1);
            setWinPercentageBox();
            player1Hand.setTotalCash(Integer.parseInt(totalBetBox.getText()) + Integer.parseInt(cashCountBox.getText()));
        }
        nextHandButton.setVisible(true);
    }

    public void bet5 (){
        player1Hand.setBettingValue(5);
        player1Hand.setTotalCash(Integer.parseInt(cashCountBox.getText())-5);
        betSettings();
    }

    public void bet25 (){
        player1Hand.setBettingValue(25);
        player1Hand.setTotalCash(Integer.parseInt(cashCountBox.getText())-25);
        betSettings();
    }

    public void bet100 (){
        player1Hand.setBettingValue(100);
        player1Hand.setTotalCash(Integer.parseInt(cashCountBox.getText())-100);
        betSettings();
    }

    public void betSettings(){
        dealButton.setVisible(true);
        setTotalBetBox();
        setCashCountBox();
    }

    public void reset (){   //Function for resetting everything after every hand.
        setCashCountBox();
        totalBetBox.setText(null);
        player1Hand.setBettingValue(0);
        nextHandButton.setVisible(false);
        hitMeButton.setVisible(false);
        stayButton.setVisible(false);
        player1Hand.setHandValue(0);
        computerHand.setHandValue(0);
        bet100.setVisible(true);
        bet25.setVisible(true);
        bet5.setVisible(true);
        cardOnePlayerImage.setImage(null);
        cardTwoPlayerImage.setImage(null);
        cardThreePlayerImage.setImage(null);
        cardFourPlayerImage.setImage(null);
        cardFivePlayerImage.setImage(null);
        cardSixPlayerImage.setImage(null);
        cardOneComputerImage.setImage(null);
        cardTwoComputerImage.setImage(null);
        cardThreeComputerImage.setImage(null);
        cardFourComputerImage.setImage(null);
        cardFiveComputerImage.setImage(null);
        cardSixComputerImage.setImage(null);
        setImageViewCounter(0);
}

    public void player1Win(){
        player1Hand.setTotalCash(((Integer.parseInt(totalBetBox.getText()))*2)+Integer.parseInt(cashCountBox.getText()));
        player1Hand.setTotalHands(1);
        player1Hand.setTotalWins(1);
    }

    public void player1Lose(){
        player1Hand.setTotalCash(Integer.parseInt(cashCountBox.getText()));
        player1Hand.setTotalHands(1);
    }

    public void setTotalBetBox(){
        totalBetBox.setText(Integer.toString(player1Hand.getBettingValue())); //Set betting text box equal to total bet value.
    }

    public void setCashCountBox(){
        cashCountBox.setText(Integer.toString(player1Hand.getTotalCash()));
    }

    public void setWinPercentageBox(){
       player1Hand.setWinPercentage(player1Hand.getTotalHands(),player1Hand.getTotalWins());
        winPercentBox.setText(Float.toString(player1Hand.getWinPercentage())+ "%");
    }

    public int getImageViewCounter() {
        return imageViewCounter;
    }

    public void setImageViewCounter(int imageViewCounter) {
        this.imageViewCounter = imageViewCounter;
    }
}
