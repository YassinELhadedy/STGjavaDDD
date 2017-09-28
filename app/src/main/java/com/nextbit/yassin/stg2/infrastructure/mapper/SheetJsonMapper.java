package com.nextbit.yassin.stg2.infrastructure.mapper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.nextbit.yassin.stg2.domain.entity.Sheet;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by yassin on 9/13/17.
 */

public class SheetJsonMapper {
    private final Gson gson;

    public SheetJsonMapper(Gson gson) {
        this.gson = gson;
    }


    public Sheet transformSheetEntity(String userJsonResponse) throws JsonSyntaxException {
        final Type userEntityType = new TypeToken<Sheet>() {}.getType();
        return this.gson.fromJson(userJsonResponse, userEntityType);
    }


    public List<Sheet> transformSheetEntityCollection(String userListJsonResponse)
            throws JsonSyntaxException {
        final Type listOfUserEntityType = new TypeToken<List<Sheet>>() {}.getType();
        return this.gson.fromJson(userListJsonResponse, listOfUserEntityType);
    }
}
