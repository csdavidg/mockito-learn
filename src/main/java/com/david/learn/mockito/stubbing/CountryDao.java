package com.david.learn.mockito.stubbing;

import java.util.List;

public interface CountryDao {

	List<Country> retrieve(RetrieveCountryRequest command);
}
