//The graphql server

import { startServerAndCreateNextHandler } from "@as-integrations/next";
import { typeDefs } from "@/graphql/schema";
import { resolvers } from "@/graphql/resolvers";
import { ApolloServer } from "@apollo/server";
import { NextApiRequest, NextApiResponse } from "next";
import { TContext } from "@/types";
import prisma from "@/utils/db";

const apolloServer = new ApolloServer<TContext>({
  typeDefs,
  resolvers,
});
export default startServerAndCreateNextHandler(apolloServer, {
  context: async (req: NextApiRequest, res: NextApiResponse) => ({
    req,
    res,
    prisma,
  }),
});
