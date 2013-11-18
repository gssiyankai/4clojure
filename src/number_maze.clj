(ns number_maze)

(use 'clojure.set)

(defn next-numbers [n]
  (->> (map #(% n 2) [/ * +])
       (filter #(integer? %))
       (distinct))
)

(defn shortest-path
  ([start end]
    (shortest-path #{start} end #{start}))
  ([starts end cache]
    (if (contains? starts end)
      1
      (inc (shortest-path (set (flatten (map #(next-numbers %) starts)))
                          end
                          (clojure.set/union cache starts)))
    )
  )
)