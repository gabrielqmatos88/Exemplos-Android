public static class SalvarGenerico
   {
       public static void Salvar<TEntity>( this WexDb contexto, Expression<Func<WexDb, DbSet<TEntity>>> expressao, TEntity entidade ) where TEntity : Entidade
       {
           DbSet<TEntity> colecao = expressao.Compile().Invoke( contexto );

           if(!colecao.ExisteLocalmente( o => o.Oid == entidade.Oid )) 
           {
               colecao.Attach( entidade );
           }

           if(colecao.Existe( o => o.Oid == entidade.Oid ))
           {
               contexto.Entry( entidade ).State = EntityState.Modified;
           }
           else 
           {
               contexto.Entry( entidade ).State = EntityState.Added;
           }
           contexto.SaveChanges();
       }
   }