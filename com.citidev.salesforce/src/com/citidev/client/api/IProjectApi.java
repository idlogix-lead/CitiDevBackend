package com.citidev.client.api;


import java.util.List;
//import java.util.Map;


import com.citidev.dto.ProjectDTO;

public interface IProjectApi {
    List<ProjectDTO> getAllProjects();
    ProjectDTO getProjectById(String id);
//    void updateProject(String id,Map<String,Object> data);
}

