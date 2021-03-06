package edu.coursemgr.dao;

import edu.coursemgr.model.GroupMember;

import java.util.List;

public interface GroupMemberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GroupMember record);

    int insertSelective(GroupMember record);

    GroupMember selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GroupMember record);

    int updateByPrimaryKey(GroupMember record);

    /**
     * 批量插入组员信息
     * @param groupMembers
     * @return
     */
    int insertBatch(List<GroupMember> groupMembers);
}