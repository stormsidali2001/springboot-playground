package com.example.msuser.Repositories;

import com.example.msuser.Entities.VirtualMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VirtualMachineRepository extends JpaRepository<VirtualMachine,Long> {
    @Query("select sum (m.configuration.ram) from VirtualMachine m where m.serverId = :ids")
    public Long sumRamServer(@Param("ids") Long ids);
}
