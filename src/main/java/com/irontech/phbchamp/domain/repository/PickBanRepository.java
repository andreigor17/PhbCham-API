/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.irontech.phbchamp.domain.repository;

import com.irontech.phbchamp.domain.model.PickBan;
import java.util.List;

/**
 *
 * @author andreigor
 */
public interface PickBanRepository {

    List<PickBan> listar();

    PickBan buscar(Long id);

    PickBan salvar(PickBan pb);

    void remover(Long id);

}
