package tceia.technology.service.impl;

import tceia.technology.entity.A;
import tceia.technology.mapper.AMapper;
import tceia.technology.service.IAService;
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
public class AServiceImpl extends ServiceImpl<AMapper, A> implements IAService {

}
