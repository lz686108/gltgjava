package tceia.technology.service.impl;

import tceia.technology.entity.List;
import tceia.technology.mapper.ListMapper;
import tceia.technology.service.IListService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lizhen
 * @since 2021-12-14
 */
@Service
public class ListServiceImpl extends ServiceImpl<ListMapper, List> implements IListService {

}
