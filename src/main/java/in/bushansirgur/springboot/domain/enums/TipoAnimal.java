package in.bushansirgur.springboot.domain.enums;

public enum TipoAnimal {

	BOVINO(1, "Bovino"),
	SUINO(2, "Suino"),
	OVINO(3, "Ovino"),
	CAPRINO(4, "Caprino"),
	AVE(5, "Ave"),
	EQUINO(6, "Equino");

	private int cod;
	private String descricao;

	private TipoAnimal(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoAnimal toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}
		for (TipoAnimal x : TipoAnimal.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}

		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
