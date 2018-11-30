package com.company.project.service;
import com.company.project.model.Back;
import com.company.project.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/11/26.
 */

public interface BackService extends Service<Back> {

    List<Back> getAll();
}
