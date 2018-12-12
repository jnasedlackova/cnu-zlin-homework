package dk.cngroup.university;

public enum Field {
	ACCESSIBLE("."),
	INACCESSIBLE("0");

	private final String symbol;

	Field(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}
}
