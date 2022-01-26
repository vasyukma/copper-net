package vasyuk.maksim.copper_net.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import vasyuk.maksim.copper_net.dto.LinkDto;
import vasyuk.maksim.copper_net.mapper.LinkMapper;
import vasyuk.maksim.copper_net.model.Link;
import vasyuk.maksim.copper_net.repository.LinksRepository;

@org.springframework.stereotype.Service
public class LinksServiceImpl implements LinksService {

    private LinksRepository repository;
    private LinkMapper mapper;

    @Autowired
    public LinksServiceImpl(LinksRepository repository, LinkMapper mapper) {
        super();
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<LinkDto> getAll() {
        return mapper.map(repository.findAll());
    }

    @Override
    public LinkDto getById(Long id) {
        return mapper.map(repository.getById(id));
    }

    @Override
    public LinkDto create(LinkDto dto) {
        return mapper.map(repository.save(mapper.map(dto)));
    }

    @Override
    public LinkDto update(LinkDto dto) {
        Link model = repository.getById(dto.getId());
        mapper.updateModel(dto, model);
        model = repository.save(model);
        return mapper.map(model);
    }

}
