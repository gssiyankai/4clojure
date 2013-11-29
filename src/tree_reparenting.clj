(ns tree_reparenting)


(defn parse [cache node parent children]
  (merge {node [parent (map first children)]}
         (apply merge (map #(parse cache (first %) node (rest %)) children)))
)

(defn connect [root cache]
  (let [children-and-parent (->> (cond (nil? (first (cache root))) (second (cache root))
                                        :else (flatten [(second (cache root)) (first (cache root))]))
                                 (filter #(contains? cache %)))
        new-cache (dissoc cache root)]
    (cons root (map #(connect % new-cache) children-and-parent))
  )
)

(defn reconnect [node tree]
  (let [cache (parse {} (first tree) nil (rest tree))
        new-tree (connect node cache)]
    new-tree
  )
)