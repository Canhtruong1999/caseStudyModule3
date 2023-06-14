package service;

import dao.TagDao;
import model.Tag;

import java.util.List;

public class TagService {
    TagDao tagDao =new TagDao();
    public List<Tag> findAll(){
        return tagDao.findAll();
    }
    public Tag findById(int id){
        return tagDao.findById(id);
    }
}
