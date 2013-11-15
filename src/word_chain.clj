(ns word_chain)

(defn can-chain
  ([words] (can-chain (set (rest words)) (first words) nil))
  ([words first_chain_word last_chain_word]
    (let [remove-common-leading-chars (fn remove-common-leading-chars [[word1 word2]]
                                        (if (or (empty? word1)
                                              (empty? word2)
                                              (not= (first word1) (first word2)))
                                          [(apply str word1) (apply str word2)]
                                          (remove-common-leading-chars [(rest word1) (rest word2)])
                                          )
                                        )
          remove-common-trailing-chars (fn [[word1 word2]]
                                          (map
                                            #(apply str (reverse %))
                                            (remove-common-leading-chars [(reverse word1) (reverse word2)])
                                            )
                                          )
          strip (fn [[word1 word2]]
                  (remove-common-trailing-chars
                    (remove-common-leading-chars [word1 word2]))
                  )
          can-chain-with-modification (fn [size word1 word2] (= size (map count (strip [word1 word2]))))
          can-chain-with-substitution (fn [word1 word2] (can-chain-with-modification [1 1] word1 word2))
          can-chain-with-insertion (fn [word1 word2] (can-chain-with-modification [0 1] word1 word2))
          can-chain-with-deletion (fn [word1 word2] (can-chain-with-insertion word2 word1))
          chain-words (fn [word] (filter #(or (can-chain-with-substitution % word)
                                              (can-chain-with-insertion % word)
                                              (can-chain-with-deletion % word))
                                         words))
          head-chain-words (chain-words first_chain_word)
          tail-chain-words (chain-words last_chain_word)]
      (or (empty? words)
          (if (nil? last_chain_word) (some #(can-chain (disj words %) first_chain_word %) head-chain-words)
                                     (some #(can-chain (disj words %) % last_chain_word) head-chain-words))
          (and (not (nil? last_chain_word)) (some #(can-chain (disj words %) first_chain_word %) tail-chain-words))
      )
    )
  )
)