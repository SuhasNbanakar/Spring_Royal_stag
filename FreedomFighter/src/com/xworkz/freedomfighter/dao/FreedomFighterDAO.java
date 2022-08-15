package com.xworkz.freedomfighter.dao;

import java.util.List;

import com.xworkz.freedomfighter.entity.FreedomFighterEntity;

public interface FreedomFighterDAO {

	boolean save(FreedomFighterEntity entity);

	default boolean saveAll(List<FreedomFighterEntity> fighterEntities) {
		return false;

	}

}
