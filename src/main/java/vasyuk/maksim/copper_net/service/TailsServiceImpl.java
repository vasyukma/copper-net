package vasyuk.maksim.copper_net.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import vasyuk.maksim.copper_net.dto.TailDto;
import vasyuk.maksim.copper_net.mapper.TailMapper;
import vasyuk.maksim.copper_net.model.Tail;
import vasyuk.maksim.copper_net.repository.TailsRepository;

@org.springframework.stereotype.Service
public class TailsServiceImpl implements TailsService {
    private TailsRepository repository;
    private TailMapper mapper;

    @Autowired
    public TailsServiceImpl(TailsRepository repository, TailMapper mapper) {
        super();
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<TailDto> getAll() {
        return mapper.map(repository.findAll());
    }

    @Override
    public TailDto getById(Long id) {
        return mapper.map(repository.getById(id));
    }

    @Override
    public TailDto create(TailDto dto) {
        return mapper.map(repository.save(mapper.map(dto)));
    }

    @Override
    public TailDto update(TailDto dto) {
        Tail model = repository.getById(dto.getId());
        mapper.updateModel(dto, model);
        model = repository.save(model);
        return mapper.map(model);
    }

    @Override
    public List<TailDto> getTailsByNodeId(Long nodeId) {
        return mapper.map(repository.findByNodeId(nodeId));
    }
}
