package net.xdclass.online_xdclass.mapper;

import net.xdclass.online_xdclass.model.entity.VideoOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoOrderMapper {

    /**
     * 查询用户是否购买过此商品
     * @param userId
     * @param vidoeId
     * @param state
     * @return
     */
    VideoOrder findByUserIdAndVideoIdAndState(@Param("user_id") int userId, @Param("video_id") int videoId, @Param("state") int state);


    /**
     * 下单
     * @return
     */
    int saveOrder(VideoOrder videoOrder);


    /**
     * @Function: 功能描述 视频列表
     * @Author: ChenXW
     * @Date: 20:13 2022/10/11
     */
    List<VideoOrder> listOrderByUserId(@Param("user_id") Integer userId);
}
