package baseball.controller;

import baseball.Constants;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    public List<Integer> generateRandomNumbers() {
        List<Integer> randomNumberList = new ArrayList<>();

        while(randomNumberList.size() < Constants.RANDOM_NUMBER_LENGTH){
            addRandomNumberToList(randomNumberList);
        }

        return randomNumberList;
    }

    private void addRandomNumberToList(List<Integer> randomNumberList){
        int randomNumber = Randoms.pickNumberInRange
                (Constants.START_INCLUSIVE, Constants.END_INCLUSIVE);

        if(!randomNumberList.contains(randomNumber)){
            randomNumberList.add(randomNumber);
        }
    }
}
