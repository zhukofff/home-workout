package com.example.gym.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.preferencesKey
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

enum class SortOrder {
    BY_CATEGORY,
    BY_TIME,
    BY_COMPLEXITY,
    BY_TITLE,
    NULL
}
private object PreferencesKeys {
    val sortOrder = preferencesKey<String>("sort_order")
}
class UserPreferences
@Inject constructor (val userPreferencesStore: DataStore<Preferences>) {


    /*
    So what does i need?
    for what i created data store preferens?
    what i will save in the data store?
    if have some sorting then we save it to data store
    what sorting was used last time?
    so, okay i used sorting will it save to next time?
    nope, bcs favourite view model just get list of exercises without sorting
    1. it meaning that i need to save what sorting was used last time
    It's all?
    2. okay, user skip exercise and timer not saving, so i need to do like
        1. skip exercise (check others or exit application)
        2. save time
        3. open exercise
        4. Wow! That's my last time!
    3. favourite image, what is not okay with that?
        1. if clicked on favourite than update iconCode and isSaved to true
        2. if it is in favourite then update iconCode to not filled and isSaved to false

     */

    val userPreferencesFlow: Flow<SortOrder> = userPreferencesStore.data
        .catch { exception ->
            if (exception is IOException)
                emit(emptyPreferences())
            else
                throw exception
        }
        .map { preferences ->
            val sortOrder = SortOrder.valueOf(preferences[PreferencesKeys.sortOrder]!!)
            sortOrder
        }

    suspend fun setSortOrder(order: String) {
        userPreferencesStore.edit { preferences ->
            preferences[PreferencesKeys.sortOrder] = order
        }
    }

}