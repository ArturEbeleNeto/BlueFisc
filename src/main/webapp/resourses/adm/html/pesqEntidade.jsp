<!-- Button trigger modal -->
<button style="display: none;" id="btnChamaModal" hidden="hidden" class="btn btn-primary" data-toggle="modal" data-target="#modalTablePesqEntidade">
</button>	
<div class="modal fade" id="modalTablePesqEntidade" tabindex="-100" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">Pesquisa de cadastros</h4>
            </div>
            <div class="modal-body">
                <table id="tablePesqEntidade"
                       data-toggle="table"
                       data-height="299"
                       data-search="true"
                       data-striped ="true"
                       data-click-to-select="true" 
                       data-single-select="true"
                       data-maintain-selected="true">                       
                    <thead>
                    <tr>
                        <th data-field="id">ID</th>
                        <th data-field="descricao">Descrição</th>
                    </tr>
                    </thead>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="btnFechaModal" data-dismiss="modal">Fechar</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<script src="<%=request.getContextPath()%>/resourses/js/plugins/pesqEntidade.js"></script>