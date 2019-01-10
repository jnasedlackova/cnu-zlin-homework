package dk.cngroup.university;

import java.util.List;

public class Landscape {
	private Field[][] fields;

	public Landscape(int size, List<Position> inaccessiblePositions) {
		initAccessibleLandscape(size);
		insertInaccessibleFields(inaccessiblePositions);
	}

	public boolean isAccessible(Position position){
        Field field = fields[position.x][position.y];
        if (field.toString().equals("."))
            return true;
        else return false;
	}

	@Override
	public String toString() {
		String output = "";
		for (Field[] row : fields) {
			for (Field field : row) {
				output += field.toString();
			}
			output += "\n";
		}
		return output;
	}

	private void insertInaccessibleFields(List<Position> inaccessiblePositions) {
		for (Position p : inaccessiblePositions) {
            if (p.x < fields.length && p.y < fields.length && p.x > -1 && p.y > -1) {
                fields[p.x][p.y] = Field.INACCESSIBLE;
            }
		}
	}

	private void initAccessibleLandscape(int size) {
		this.fields = new Field[size][size];
		for (int i = 0; i < fields.length; i++){
			for (int j = 0; j < fields[i].length; j++){
				fields[i][j] = Field.ACCESSIBLE;
			}
		}
	}

    public Field[][] getFields() {
        return fields;
    }
}
