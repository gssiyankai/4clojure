(ns tree_reparenting)


(defn reconnect [node tree]
  (let [parse (fn parse [node parent children]
                (merge {node [parent (map first children)]}
                  (apply merge (map #(parse (first %) node (rest %)) children)))
              )
        cache (parse (first tree) nil (rest tree))
        connect (fn connect [root cache]
                  (let [children-and-parent (->> (cond (nil? (first (cache root))) (second (cache root))
                                                       :else (flatten [(second (cache root)) (first (cache root))]))
                                                 (filter #(contains? cache %)))
                        new-cache (dissoc cache root)]
                    (cons root (map #(connect % new-cache) children-and-parent))
                  )
                )
        new-tree (connect node cache)]
    new-tree
  )
)