package com.riwi.TechQuest.domain.services.Interface;

import com.riwi.TechQuest.domain.entities.UserEntity;
import com.riwi.TechQuest.domain.services.crud.Create;
import com.riwi.TechQuest.domain.services.crud.Delete;
import com.riwi.TechQuest.domain.services.crud.GetByName;
import com.riwi.TechQuest.domain.services.crud.Update;

public interface IUserService extends
        Create<UserEntity, UserEntity>,
        Update<Long, UserEntity>,
        GetByName<UserEntity, String>,
        Delete<Long>{
}
