JdbcConfig jdbcConfig = new JdbcConfig();
BitmessageContext ctx = new BitmessageContext.Builder()
	.addressRepo(new JdbcAddressRepository(jdbcConfig))
	.inventory(new JdbcInventory(jdbcConfig))
	.nodeRegistry(new MemoryNodeRegistry())
	.messageRepo(new JdbcMessageRepository(jdbcConfig))
	.powRepo(new JdbcProofOfWorkRepository(jdbcConfig))
	.networkHandler(new DefaultNetworkHandler())
	.cryptography(new BouncyCryptography())
	.listener(new BitmessageContext.Listener() {
	    @Override
	    public void receive(Plaintext plaintext) {
	        // TODO: notify the user
	    }
	})
	.build();

ctx.startup();