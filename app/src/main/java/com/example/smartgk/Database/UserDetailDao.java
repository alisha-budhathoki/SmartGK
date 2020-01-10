package com.example.smartgk.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

@Dao
public interface UserDetailDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertVendorDetails(UserDetails userDetail);

}
