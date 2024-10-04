package com.riwi.TechQuest.application.services.interfaces;

import com.riwi.TechQuest.application.dto.request.SkillRequest;
import com.riwi.TechQuest.application.dto.response.SkillResponse;
import com.riwi.TechQuest.application.services.crud.Delete;
import com.riwi.TechQuest.application.services.crud.Update;
import com.riwi.TechQuest.domain.model.entities.Skill;
import com.riwi.TechQuest.application.services.crud.Create;
import com.riwi.TechQuest.application.services.crud.GetByName;
import jakarta.transaction.Transactional;

public interface ISkillService extends
        Create<SkillRequest, SkillResponse>,
        Delete<Long>,
        GetByName<SkillResponse, String>,
        Update<Long, SkillRequest> {
}
