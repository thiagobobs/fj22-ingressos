	<ingresso:template>
					<jsp:body>
									<form	action="/usuario/cadastrar"	method="post">
													<span	class="text-danger">${param.error}</span>
													<input	type="hidden"	name="token.uuid"	value="${confirmacaoLoginForm.token.uuid}">
													<input	type="hidden"	name="token.email"	value="${confirmacaoLoginForm.token.email}">
													<div	class="form-group">
																	<label	for="password">Senha:</label>
																	<input	id="password"	type="password"	name="password"	class="form-control">
													</div>
													<div	class="form-group">
																	<label	for="confirmPassword">Senha:</label>
																	<input	id="confirmPassword"	type="password"	name="confirmPassword"	class="form-co
ntrol">
													</div>
													<button	class="btn	btn-primary"	type="submit">Cadastrar</button>
									</form>
					</jsp:body>
	</ingresso:template>