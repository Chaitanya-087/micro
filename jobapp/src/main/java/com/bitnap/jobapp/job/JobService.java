package com.bitnap.jobapp.job;

import java.util.List;

public interface JobService {


    List<Job> findAll();

    void createJob(Job job);

    Job findById(Long id);

    Boolean deleteById(Long id);

    Boolean updateJob(Long id, Job updatedJob);
}

