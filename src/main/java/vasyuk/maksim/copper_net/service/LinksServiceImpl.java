package vasyuk.maksim.copper_net.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import vasyuk.maksim.copper_net.dto.LinkDto;
import vasyuk.maksim.copper_net.dto.TailDto;
import vasyuk.maksim.copper_net.mapper.LinkMapper;
import vasyuk.maksim.copper_net.mapper.TailMapper;
import vasyuk.maksim.copper_net.model.Link;
import vasyuk.maksim.copper_net.repository.LinksRepository;
import vasyuk.maksim.copper_net.repository.TailsRepository;

@org.springframework.stereotype.Service
public class LinksServiceImpl implements LinksService {
    private LinksRepository linksRepository;
    private TailsRepository tailsRepository;
    private LinkMapper linkMapper;
    private TailMapper tailMapper;

    @Autowired
    public LinksServiceImpl(LinksRepository linksRepository, TailsRepository tailsRepository, LinkMapper linkMapper,
            TailMapper tailMapper) {
        super();
        this.linksRepository = linksRepository;
        this.tailsRepository = tailsRepository;
        this.linkMapper = linkMapper;
        this.tailMapper = tailMapper;
    }

    @Override
    public List<LinkDto> getAll() {
        return linkMapper.map(linksRepository.findByOrderByNameAsc());
    }

    @Override
    public LinkDto getById(Long id) {
        return linkMapper.map(linksRepository.getById(id));
    }

    @Override
    public LinkDto create(LinkDto dto) {
        return linkMapper.map(linksRepository.save(linkMapper.map(dto)));
    }

    @Override
    public LinkDto update(LinkDto dto) {
        Link model = linksRepository.getById(dto.getId());
        linkMapper.updateModel(dto, model);
        model = linksRepository.save(model);
        return linkMapper.map(model);
    }

    @Override
    public List<TailDto> getChildren(Long linkId) {
        return tailMapper.map(tailsRepository.findByLinkId(linkId));
    }

    @Override
    public List<LinkDto> getByNameStartsWith(String name) {
      return linkMapper.map(linksRepository.findByNameLikeOrderByNameAsc(name));
    }
}
