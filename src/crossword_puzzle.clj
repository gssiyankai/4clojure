(ns crossword_puzzle)

(defn can-place [word board]
  (let [partial-line-words (fn [line] (->> (filter #(not= % \space) line)
                                           (partition-by #(= % \#))
                                           (filter #(not= % '(\#)))
                                           (map #(apply str %))))
        partial-words (flatten (vector (map partial-line-words board)
                                       (map #(apply str %) (apply map vector (flatten board)))))
        candidate (fn [partial-word] (and (= (count word) (count partial-word))
                                          (->> (map vector word partial-word)
                                               (drop-while #(or (= (second %) \_) (apply = %)))
                                               (empty?))))
        candidates (filter #(candidate %) partial-words)]
      (not (empty? candidates))
    )
)