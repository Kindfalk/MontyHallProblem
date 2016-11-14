package se.adwisit.montyhall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PuzzleBoard {
	private int numerOfChoices = 3;
	private List<PrizeHolder> possibilityList = null;
	private Random rand = new Random();
	
	public PuzzleBoard(){
		
	}

	public void generateNewBoard() {
		possibilityList = new ArrayList<PrizeHolder>(numerOfChoices);
		int prizePosition = rand.nextInt(numerOfChoices);
		
		for (int i = 0 ; i < numerOfChoices ; i++){
			if (i !=  prizePosition){
				possibilityList.add(new Box(false));
			} else {
				possibilityList.add(new Box(true));
			}
		}
	}

	public List<Integer> getClosedList() {
		List<Integer> valueList = new ArrayList<Integer>();
		for (int i = 0 ; i < possibilityList.size() ; i++){
			PrizeHolder content = possibilityList.get(i);
			if (!content.isOpen()){
				valueList.add(i);
			}
		}
		return valueList;
	}
	
	public Boolean peakInsideAtPosition(int index) {
		Boolean prize = null;
		if (index >= 0 && index < possibilityList.size()){
			prize = possibilityList.get(index).peakInside();
		}
		return prize;
	}

	public Boolean getPrizeAtPosition(int index) {
		Boolean prize = null;
		if (index >= 0 && index < possibilityList.size()){
			prize = (Boolean) possibilityList.get(index).getWinnig();
		}
		return prize;
	}
	
	public List<PrizeHolder> getCheatListForTesting(){
		return possibilityList;		
	}

}
