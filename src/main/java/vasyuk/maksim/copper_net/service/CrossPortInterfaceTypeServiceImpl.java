package vasyuk.maksim.copper_net.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.dto.CrossPortInterfaceTypeDto;
import vasyuk.maksim.copper_net.model.CrossPortInterfaceType;
import vasyuk.maksim.copper_net.repository.CrossPortInterfaceTypeRepository;

@Service
public class CrossPortInterfaceTypeServiceImpl implements CrossPortInterfaceTypesService {
    private CrossPortInterfaceTypeRepository repository;

    public CrossPortInterfaceTypeServiceImpl(CrossPortInterfaceTypeRepository repository) {
        super();
        this.repository = repository;
    }

    void tmp() {
        Pageable sortedByName = PageRequest.of(0, 0, Sort.by("name"));
        Page<CrossPortInterfaceType> allCrossPortInterfaceTypesSortedByName = repository.findAll(sortedByName);
        allCrossPortInterfaceTypesSortedByName.map(type -> new CrossPortInterfaceTypeDto(type.getId(), type.getName()));
    }

    @Override
    public List<CrossPortInterfaceTypeDto> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CrossPortInterfaceTypeDto getById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CrossPortInterfaceTypeDto create(CrossPortInterfaceTypeDto dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CrossPortInterfaceTypeDto update(CrossPortInterfaceTypeDto dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<CrossPortInterfaceTypeDto> getAllPage() {
        Pageable sortedByName = PageRequest.of(0, 100, Sort.by("name"));
        Page<CrossPortInterfaceType> allCrossPortInterfaceTypesSortedByName = repository.findAll(sortedByName);
        return allCrossPortInterfaceTypesSortedByName.map(type -> new CrossPortInterfaceTypeDto(type.getId(), type.getName()));
        
//        return null;
    }
}
