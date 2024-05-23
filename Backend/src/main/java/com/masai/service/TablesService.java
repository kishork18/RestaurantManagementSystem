package com.masai.service;

import com.masai.entity.Tables;

public interface TablesService {
	public Tables createTable(Tables tables);

	public Tables deleteTable(long id);
}
