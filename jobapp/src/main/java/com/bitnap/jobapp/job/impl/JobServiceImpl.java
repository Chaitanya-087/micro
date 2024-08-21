package com.bitnap.jobapp.job.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bitnap.jobapp.job.Job;
import com.bitnap.jobapp.job.JobRepository;
import com.bitnap.jobapp.job.JobService;

@Service
public class JobServiceImpl implements JobService {
    private JobRepository jobRepository;
    
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job findById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean deleteById(Long id) {
        try {
            jobRepository.deleteById(id);
        } catch(Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOpty = jobRepository.findById(id);
        if(jobOpty.isPresent()) {
            Job job = jobOpty.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;
    }

}
