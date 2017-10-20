# tech

Shards Vs Partitions 
-- sharding is distribution or partition of data across multiple different machines whereas partitioning is distribution of data on the same machine
-- https://www.quora.com/Whats-the-difference-between-sharding-DB-tables-and-partitioning-them
-- Shared nothing architecture for shards (data resides in multiple nodes)
-- Hash, Range, and List based partitioning - given a key for a record, determine the destination partition that it will belong to.

Replica
-- https://dba.stackexchange.com/questions/52632/difference-between-sharding-and-replication-on-mongodb
-- A replica-set consists of one Master (also called "Primary") and one or more Slaves (aka Secondary). -- Read-operations can be served by any slave, so you can increase read-performance by adding more slaves to the replica-set
-- Write-operations always take place on the master of the replica-set and are then propagated to the slaves, so writes won't get faster when you add more slaves.
-- Replica-sets also offer fault-tolerance. When one of the members of the replica-set goes down, the others take over. When the master goes down, the slaves will elect a new master.
-- replica-set of at least three servers, two of them holding data (the third one is a data-less "arbiter" which is required for determining a new master when one of the slaves goes down).

Inverted Index
-- An inverted index consists of a list of all the unique words that appear in any document, and for each word, a list of the documents in which it appears
-- Use similarity algorithm 
-- Synonyms -- not from the same root word, are similar in meaning
-- Analysis & Analyzers -- 
     tokenizing a block of text into individual terms suitable for use in an inverted index
     normalizing these terms into a standard form to improve their “searchability,”
     Elasticsearch provides many character filters, tokenizers, and token filters out of the box
     	Character filter (tidy up the string before tokenization strip out HTML, or to convert & etc)
     	Tokenizer split the text into terms whenever it encounters whitespace or punctuation
     	Token Filter change terms (lower case), remove terms, add terms (synonyms etc)
     	
Stack Vs Heap
-- we create any object, it’s always created in the Heap space

     	
 