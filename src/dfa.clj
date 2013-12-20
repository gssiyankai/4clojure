(ns dfa)

(defn language
  ([definition]
    (let [start (definition :start)
          transitions (definition :transitions)
          accepts (definition :accepts)]
      (language transitions start accepts "")
    )
  )
  ([transitions start accepts word]
    (let [acceptable-starts (transitions start)
          acceptable-states (filter #(contains? accepts (val %)) acceptable-starts)
          acceptable-words (map #(str word (key %)) acceptable-states)
          next-words (map #(vector (str word (key %)) (val %)) acceptable-starts)
          next-transitions (dissoc transitions start)]
      (flatten (conj acceptable-words (lazy-seq (map #(language next-transitions (second %) accepts (first %)) next-words))))
    )
  )
)
