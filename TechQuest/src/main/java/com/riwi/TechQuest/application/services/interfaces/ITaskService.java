package com.riwi.TechQuest.application.services.interfaces;

import com.riwi.TechQuest.application.dto.request.TaskRequest;
import com.riwi.TechQuest.application.dto.response.TaskResponse;
import com.riwi.TechQuest.application.services.crud.*;
import com.riwi.TechQuest.domain.model.entities.Task;

public interface ITaskService extends
        Create<TaskRequest,TaskResponse>,
        Delete<Long>,
        GetByTitle<TaskResponse, String>,
        Update<Long, TaskRequest> {
}
