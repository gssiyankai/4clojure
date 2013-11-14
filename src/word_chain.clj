(ns word_chain)

(defn can-chain [words]
  (let [remove-common-leading-chars (fn remove [word1 word2] (if (or (empty? word1) (empty? word2) (not= (first word1) (first word2)))
                                                        [word1 word2]
                                                        (remove (rest word1) (rest word2))))
        remove-common-trailing-chars (fn [[word1 word2]] (map #(apply str (reverse %)) (remove-common-leading-chars (reverse word1) (reverse word2))))
        remove-common-leading-and-trailing-chars (fn [word1 word2] (remove-common-trailing-chars (remove-common-leading-chars word1 word2)))
        can-chain-with-modification (fn [counts word1 word2] (= counts (map #([(count (first %)) (count (second %))]) (remove-common-leading-and-trailing-chars word1 word2))))
        can-chain-with-substitution (fn [word1 word2] (can-chain-with-modification [1 1] word1 word2))
        can-chain-with-insertion (fn [word1 word2] (can-chain-with-modification [0 1] word1 word2))
        can-chain-with-deletion (fn [word1 word2] (can-chain-with-insertion word2 word1))]
    (or (can-chain-with-substitution (first words) (second words))
        (can-chain-with-insertion (first words) (second words))
        (can-chain-with-deletion (first words) (second words))
    )
  )
)
