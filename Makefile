populate_database:
	curl -H "Content-Type: application/x-ndjson" -XPOST https://localhost:9200/wikipedia/_bulk --data-binary "@wiki.json" --user "elastic:user123" --insecure && \
	curl -H "Content-Type: application/x-ndjson" -XPOST https://localhost:9200/users/_doc --data-binary "@wiki_admin_account.json" --user "elastic:user123" --insecure
