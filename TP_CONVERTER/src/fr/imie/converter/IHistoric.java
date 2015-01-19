package fr.imie.converter;

import java.util.List;
import java.util.ArrayList;

public interface IHistoric {
	public abstract List<DataGui> getHistoric();
	public abstract void AddHistoric(DataGui data);
}
