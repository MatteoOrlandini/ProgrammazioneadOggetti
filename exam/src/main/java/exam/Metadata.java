package exam;

/**
 * Used by {@link CSVParser} to store the first line with the fields of the
 * data-set. It represents the attributes of a pharmacy.
 *
 */
public class Metadata {
	private String alias;
	private String sourceField;
	private String type;

	public Metadata(String alias, String sourceField, String type) {
		super();
		this.alias = alias;
		this.sourceField = sourceField;
		this.type = type;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getSourceField() {
		return sourceField;
	}

	public void setSourceField(String sourceField) {
		this.sourceField = sourceField;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Metadata [alias=" + alias + ", sourceField=" + sourceField + ", type=" + type + "]";
	}
}
