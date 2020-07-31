package czytytanie.plik;

import java.util.ArrayList;
import java.util.List;

public class PairCountPosition {

	private Integer count;
	private List<Integer> positions = new ArrayList<Integer>();
	
	public PairCountPosition(Integer position) {
		count = 1;
		positions.add(position);
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<Integer> getPositions() {
		return positions;
	}

	public void setPositions(List<Integer> positions) {
		this.positions = positions;
	}
	
	public void incremateCount() {
		count++;
	}
	
	public void addPosition(Integer position) {
		positions.add(position);
	}

}
