package com.java.Hibemp;

import java.util.List;

public interface VictimDAO {
	void addVictim(Victim victim);

	Victim getVictim(int victimId);

	List<Victim> getAllVictims();

	void updateVictim(Victim victim);

	void deleteVictim(int victimId);
}
